package practice.DSDesign.Lyft.KeyValueStores;


import java.util.Objects;

public class TransactionalLogTest {
    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        run("01. Repeated updates", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.set("A", "20");
            db.set("A", "30");
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("02. Rollback newly created key", () -> {
            TransactionalLog db = new TransactionalLog();
            db.begin();
            db.set("B", "100");
            db.rollback();
            assertEquals(null, db.get("B"));
        });

        run("03. Rollback deletion", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.delete("A");
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("04. Inner-only update", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.begin();
            db.set("A", "30");
            db.commit();
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("05. Parent and child update", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.set("A", "20");
            db.begin();
            db.set("A", "30");
            db.commit();
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("06. Inner creates key", () -> {
            TransactionalLog db = new TransactionalLog();
            db.begin();
            db.begin();
            db.set("C", "50");
            db.commit();
            db.rollback();
            assertEquals(null, db.get("C"));
        });

        run("07. Nested rollbacks", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.set("A", "20");
            db.begin();
            db.set("A", "30");
            db.rollback();
            assertEquals("20", db.get("A"));
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("08. Outermost commit", () -> {
            TransactionalLog db = new TransactionalLog();
            db.begin();
            db.set("A", "100");
            db.commit();
            assertEquals("100", db.get("A"));
        });

        run("09. Invalid commit", () -> {
            TransactionalLog db = new TransactionalLog();
            assertThrows(IllegalStateException.class, db::commit);
        });

        run("10. Invalid rollback", () -> {
            TransactionalLog db = new TransactionalLog();
            assertThrows(IllegalStateException.class, db::rollback);
        });

        run("11. Value counts and rollback", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.set("B", "10");
            db.set("C", "20");

            assertEquals(2, db.numWithValue("10"));
            assertEquals(1, db.numWithValue("20"));

            db.begin();
            db.set("A", "20");
            db.delete("B");

            assertEquals(0, db.numWithValue("10"));
            assertEquals(2, db.numWithValue("20"));

            db.rollback();

            assertEquals(2, db.numWithValue("10"));
            assertEquals(1, db.numWithValue("20"));
        });

        run("12. Delete absent key", () -> {
            TransactionalLog db = new TransactionalLog();
            db.begin();
            db.delete("missing");
            db.rollback();
            assertEquals(null, db.get("missing"));
        });

        run("13. Parent update after child commit", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.begin();
            db.set("A", "30");
            db.commit();
            db.set("A", "40");
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("14. Delete and recreate", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.delete("A");
            db.set("A", "20");
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("15. Empty nested transaction", () -> {
            TransactionalLog db = new TransactionalLog();
            db.set("A", "10");
            db.begin();
            db.begin();
            db.commit();
            db.rollback();
            assertEquals("10", db.get("A"));
        });

        run("16. Overwrite updates counts", () -> {
            TransactionalLog db = new TransactionalLog();

            db.set("A", "10");
            db.set("A", "20");

            assertEquals(0, db.numWithValue("10"));
            assertEquals(1, db.numWithValue("20"));
        });

        run("17. Setting same value twice", () -> {
            TransactionalLog db = new TransactionalLog();

            db.set("A", "10");
            db.set("A", "10");

            assertEquals(1, db.numWithValue("10"));
        });

        run("18. Deleting missing key", () -> {
            TransactionalLog db = new TransactionalLog();

            db.delete("UNKNOWN");

            assertEquals(0, db.numWithValue("10"));
        });

        run("19. Rollback restores counts", () -> {
            TransactionalLog db = new TransactionalLog();

            db.set("A", "10");
            db.set("B", "10");

            db.begin();
            db.set("A", "20");
            db.delete("B");

            assertEquals(0, db.numWithValue("10"));
            assertEquals(1, db.numWithValue("20"));

            db.rollback();

            assertEquals(2, db.numWithValue("10"));
            assertEquals(0, db.numWithValue("20"));
        });

        run("20. Nested commit then outer rollback", () -> {
            TransactionalLog db = new TransactionalLog();

            db.set("A", "10");

            db.begin();
            db.begin();

            db.set("A", "20");
            db.set("B", "20");

            db.commit();

            assertEquals(2, db.numWithValue("20"));

            db.rollback();

            assertEquals("10", db.get("A"));
            assertEquals(null, db.get("B"));
            assertEquals(1, db.numWithValue("10"));
            assertEquals(0, db.numWithValue("20"));
        });

        run("21. Delete and recreate same value", () -> {
            TransactionalLog db = new TransactionalLog();

            db.set("A", "10");

            db.begin();
            db.delete("A");
            db.set("A", "10");

            assertEquals(1, db.numWithValue("10"));

            db.rollback();

            assertEquals("10", db.get("A"));
            assertEquals(1, db.numWithValue("10"));
        });

        System.out.println("\n==============================");
        System.out.printf(
                "RESULT: %d passed, %d failed, %d total%n",
                passed, failed, passed + failed
        );
        System.out.println("==============================");

        if (failed > 0) System.exit(1);
    }

    private static void run(String name, Runnable test) {
        try {
            test.run();
            passed++;
            System.out.println("PASS  " + name);
        } catch (Throwable e) {
            failed++;
            System.out.println("FAIL  " + name);
            System.out.println("      " + e);
        }
    }

    private static void assertEquals(
            Object expected, Object actual
    ) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(
                    "Expected <" + expected +
                            "> but got <" + actual + ">"
            );
        }
    }

    private static void assertThrows(
            Class<? extends Throwable> expectedType,
            Runnable action
    ) {
        try {
            action.run();
        } catch (Throwable actual) {
            if (expectedType.isInstance(actual)) return;

            throw new AssertionError(
                    "Expected " + expectedType.getSimpleName()
                            + " but got "
                            + actual.getClass().getSimpleName(),
                    actual
            );
        }

        throw new AssertionError(
                "Expected " + expectedType.getSimpleName()
                        + " but no exception was thrown"
        );
    }
}

