## Student Information

First Name: Lukas

Last Name: van der Gaag

Student number: 500864273

## Assignment 1

### 1. Git log

```
df069fax 2024-02-27     fix: CSRF not working for tests
15db881x 2024-02-27     fix: CORS not allowing requests from other ports
6d5a3a8x 2024-02-27     chore: Group dependencies by their destination
be619eex 2024-02-27     chore: Add constant for validation endpoint
498b14ex 2024-02-27     chore: Remove unused imports
5b1aa01x 2024-02-27     feature: Add BSN validation controller and tests
74bb2ecx 2024-02-27     chore: Add exception handling tests
3015d4ax 2024-02-27     feat: Add API exception handling
015b6fbx 2024-02-27     Merge branch 'feat/validators-implementations' into 'main'
a450a90x 2024-02-27     Feat/validators implementations
a0e2f54x 2024-02-25     Merge branch 'feat/bsn-validation-tests' into 'main'
f94d0d4x 2024-02-25     feat: Add BSN validation passing and failing tests
```

### 2. Sonarqube

A dated screenshot of the overview of the following quality gates(https://docs.sonarqube.org/latest/user-guide/quality-gates/): Reliability,
Security,Maintainability, Coverage and Duplications. Provide a short discussion of the results.

![img.png](/docs/sonarqube.png)
The only really notable thing is that the coverage is at 98% which is above the 80% threshold.  
The only class that is not covered is the `Main` class, which is the entry point of the application.

Another notable thing is that there are no security, reliability or maintainability issues.

### 3. Test Driven Development

Your best test class code snippets with a rationale why the unit tests are “good” tests. Provide a link to the Test class and the class under test in Git.

```kt
@Test
fun `BSN should pass the 11-test`() {
    val validBsnNineChars = "752311359"
    val validBsnEightChars = "54321098"
    val validBsnEightCharsPadded = "054321098"

    Assertions.assertTrue(elevenTestValidator.validate(validBsnNineChars), "BSN $validBsnNineChars should be valid")
    Assertions.assertTrue(
        elevenTestValidator.validate(validBsnEightChars),
        "BSN $validBsnEightChars should be valid because it should be padded with a zero"
    )
    Assertions.assertTrue(
        elevenTestValidator.validate(validBsnEightCharsPadded),
        "BSN $validBsnEightCharsPadded should be valid because it should be padded with a zero"
    )
}
```

The above test is a good test because it tests the `elevenTestValidator` with a valid BSN of 9 characters,
a valid BSN of 8 characters and the same 8-char BSN with a padded 0.
This tests the `elevenTestValidator` with different valid BSNs and different valid lengths.  
For the 8 character BSN, it also tests if the BSN is padded with a 0, which is a requirement of the 11-test for 8 character input.

SOLID principles: The test only tests the `elevenTestValidator`, so it has a single responsibility.  
The test is also easy to understand and does not have any dependencies on the environment or other classes.

[link-to-your-class-under-test](/src/main/kotlin/nl/hva/bsn/validators/BsnValidator.kt)

[link-to-your-test-class](/src/test/kotlin/nl/hva/bsn/BsnValidationTests.kt)

### 4. Code Reviews

Screenshots of the code reviews you have performed on code of another student as comments in Gitlab: Provide a link to the comments in Gitlab.

![img.png](/docs/comment_1.png)
![img.png](/docs/comment_2.png)
![img.png](/docs/comment_3.png)
![img.png](/docs/comment_4.png)
[link-to-comments-you-gave](https://gitlab.fdmci.hva.nl/se-specialization-2023-2/tse1/dennis-verveer/bsn/-/merge_requests/4#note_622643)



