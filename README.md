A sample project to reproduce an [issue](https://github.com/javacc/javacc/issues/292) with JavaCC grammar.

**Usage:**

1. Ensure you have JDK 11+ installed
2. Run:

```shell
./mvnw clean generate-sources test
```

The failed test(s) should point to the offending expression.
