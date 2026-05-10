# football-player-management

> Java OOP 기반 축구 선수단 관리 시스템

리버풀 FC 선수단을 도메인으로 Java의 객체지향 설계 원칙과 디자인 패턴 3가지를 적용해 구현한 선수 관리 시스템입니다.

---

## 사용 기술

- Java
- OOP (캡슐화, 상속, 다형성, 추상화)
- Strategy Pattern, Decorator Pattern, Template Method Pattern
- IntelliJ IDEA

---

## 주요 기능

- 선수 포지션 관리 (골키퍼 / 공격수 / 수비수)
- 포지션별 장비 세팅 (Strategy 패턴)
- 공격력·수비력 랜덤 스탯 부여 (Decorator 패턴)
- 포지션별 훈련 루틴 실행 (Template Method 패턴)

---

## 프로젝트 구조

```
src/
└── Test.java   # Team, Player, Position, Stat, TrainingClass 클래스 전체 포함
```

---

## 적용 디자인 패턴

### Strategy — 포지션별 장비
```java
player.setSelect(new Goalkeeper());  // 런타임에 포지션 교체 가능
player.doSetting();
```

### Decorator — 능력치 레이어링
```java
Stat stat = new DefensiveStat(new OffensiveStat(new TeamName()));
stat.stat(); // 팀명 → 공격력 → 수비력 순서로 출력
```

### Template Method — 훈련 흐름 표준화
```java
abstract class TrainingClass {
    protected abstract void keeper();     // 서브클래스에서 구현
    public void keepertrain() {           // 흐름은 부모가 제어
        keeper();
        System.out.println("1.스텝 훈련\n2.다이빙 훈련");
    }
}
```

---

## 맡은 역할

- 프로젝트 클래스 구조 설계 참여
- 디자인 패턴 흐름 이해 및 적용
- 발표 자료 제작

---

## 배운 점

처음에는 포지션별로 `if (position == "goalkeeper") { ... }` 형태의 조건문으로 구현하려 했습니다. 그런데 포지션이 추가될 때마다 코드를 수정해야 한다는 점이 불편하게 느껴졌고, Strategy 패턴을 적용하면서 **코드를 수정하지 않고 새로운 포지션 클래스만 추가하면 되는 구조**의 장점을 직접 체험했습니다.

Decorator 패턴에서는 `new DefensiveStat(new OffensiveStat(new TeamName()))` 처럼 객체를 겹겹이 감싸는 방식이 처음엔 직관적이지 않았는데, 상속 없이 기능을 조합할 수 있다는 점이 인상 깊었습니다.

---

## 어려웠던 점

선수 11명을 각각 독립 클래스로 구현하다 보니 코드 구조가 비슷한 클래스가 반복되는 문제가 있었습니다. 당시에는 우선 동작하도록 만드는 데 집중했지만, 지금 돌아보면 `Player` 클래스 하나에 이름·포지션·신체 데이터를 파라미터로 받아 처리하는 방식이 훨씬 간결했을 것 같습니다.

또한 모든 코드가 `Test.java` 파일 하나에 몰려 있어 파일이 길어질수록 관리가 어려웠습니다. 클래스별로 파일을 분리하는 것이 기본임을 나중에야 제대로 인식했습니다.

---

## 현재 문제점

- **단일 파일 구조**: 모든 클래스(선수 11개 + 패턴 클래스 전체)가 `Test.java` 하나에 몰려 있습니다. Java에서는 public 클래스마다 파일을 분리하는 것이 기본 원칙인데, 이를 지키지 못했습니다.
- **하드코딩된 데이터**: 선수 11명의 키·몸무게가 코드에 직접 박혀 있어 선수 데이터를 바꾸려면 코드를 직접 수정해야 합니다. 파라미터로 주입받는 구조가 아닙니다.
- **중복 코드**: 선수 클래스 11개가 `information()`과 `training()` 메서드 구조를 그대로 반복합니다. `Player` 객체 하나에 이름·포지션·신체 데이터를 파라미터로 넘기면 11개 클래스가 불필요해집니다.
- **콘솔 출력 의존**: 테스트와 실행이 `System.out.println()`으로만 이루어져 있어 단위 테스트 작성이 불가능합니다.

## 고민해야 할 점

- **패턴 선택의 기준**: Strategy, Decorator, Template Method를 적용했는데, 실제로 "이 상황에서 왜 이 패턴이 맞는가?"를 설명하려면 더 공부가 필요합니다. 예를 들어 포지션 장비 세팅은 Strategy 대신 단순 if-else로 충분하지 않을까? 어느 시점에 패턴이 오히려 과설계인지 기준을 세우고 싶습니다.
- **데이터 vs 코드 분리**: 선수 정보를 JSON 파일이나 DB에서 읽어오면 코드 수정 없이 선수 추가·변경이 가능합니다. 어느 수준에서 데이터를 외부화해야 유지보수성이 좋아지는지 고민이 필요합니다.
- **OOP 설계의 한계**: 11명을 각각 클래스로 만드는 방식이 OOP적으로 올바른가? 아니면 데이터 중심 설계(Data-Driven)로 접근하는 게 더 나은가?

## 아쉬운 점 및 개선 방향

- 현재는 콘솔 출력 기반이며 데이터가 코드에 하드코딩되어 있어, 선수를 추가하려면 코드를 수정해야 합니다. 데이터베이스나 JSON 파일에서 선수 데이터를 읽어오는 구조로 개선하고 싶습니다.
- 선수 11명이 각자 독립 클래스인 구조 대신, `Player` 객체 하나로 데이터를 주입하는 방식으로 리팩터링하면 코드량을 크게 줄일 수 있습니다.
- Spring Boot와 연동해 REST API 형태로 선수 데이터를 CRUD할 수 있도록 확장하고 싶습니다.

---

## 추가로 공부해야 할 내용

- 객체지향 설계 원칙 (SOLID)
- Java 파일 분리 및 패키지 구조
- Spring Boot 기반 API 개발
- JPA/Hibernate ORM
- 단위 테스트 (JUnit)
