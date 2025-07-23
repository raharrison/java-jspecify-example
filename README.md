# Java JSpecify Example

Aa minimal Java project demonstrating the usage of `JSpecify` annotations, `NullAway`, and `Error Prone` static analysis tools.
This project aims to showcase how to integrate and configure these tools in a Java project using `Gradle`.

---

### Usage

```bash
git clone https://github.com/raharrison/java-jspecify-example.git
cd java-jspecify-example
./gradlew build
```

### Notes

- The `UserRepo` class is annotated using `JSpecify`
- By default, the build is set up to fail if any `NullAway` error is reported
- Uncomment the line in `Main` to use a nullable object without a check beforehand. This will fail the build
- `NullAway` will not run on test code
- `NullAway` is configured to check all files in the specified project package. You can alternatively check only `NullMarked` code
  by annotating each class
  or through an annotated `package-info.java` file
