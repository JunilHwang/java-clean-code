# Step1 - 학습 테스트 실습

## String Class에 대한 학습 테스트

### 요구사항 1

- `1,2`을 `,`로 split 했을 때 `1과 2로 잘 분리되는지 확인`하는 학습 테스트를 구현한다.
- `1`을 `,`로 split 했을 때 `1만을 포함하는 배열이 반환되는지`에 대한 학습 테스트를 구현한다.

### 요구사항 2

- `(1,2)` 값이 주어졌을 때 String의 substring() 메소드를 활용해 `()을 제거`하고\
  `1,2`를 반환하도록 구현한다.

### 요구사항 3

- `abc` 값이 주어졌을 때 String의 `charAt()` 메소드를 활용해 `특정 위치의 문자`를 가져오는 학습 테스트를 구현한다.
- String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 `위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생`하는 부분에 대한 학습 테스트를 구현한다.
- JUnit의 `@DisplayName`을 활용해 테스트 `메소드의 의도`를 드러낸다.
- [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion) 문서 참고
  - 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
    - `assertThatIllegalArgumentException()`
    - `assertThatIllegalStateException()`
    - `assertThatIOException()`
    - `assertThatNullPointerException()`

## 코드리뷰

https://github.com/next-step/java-racingcar/pull/716

- `assertEquals`와 `assertThat`은 서로 대체할 수 있다.
```diff
+assertEquals(expected, numbers.contains(n));
-assertThat(numbers.contains(n)).isEqualTo(expected);
```

- 테스트 코드를 작성할 때 `@DisplayName`을 통해 테스트의 의도를 명확히 드러낼 것
```diff
+ @DisplayName("문자열에서 숫자 분리 테스트")
  @Test
  void 요구사항_01 () {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1", "2");
  }
```

- 명시한 것들에 대한 테스트 코드만 작성할 것

```diff
  @DisplayName("String.charAt(n) 에서 n이 String의 범위를 벗어나는 경우 StringIndexOutOfBoundsException 발생")
  @Test
  void 요구사항_03 () {
    String input = "abc";
-   assertThat(input.charAt(0)).isEqualTo('a'); // 이 부분은 분리하던가 제거하는것이 좋음
-   assertThat(input.charAt(1)).isEqualTo('b'); // 이 부분은 분리하던가 제거하는것이 좋음
-   assertThat(input.charAt(2)).isEqualTo('c'); // 이 부분은 분리하던가 제거하는것이 좋음

    assertThatThrownBy(() -> {
      input.charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);

    assertThatThrownBy(() -> {
      input.charAt(-1);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
```