# ️ 📆 프로젝트 소개
<hr>

###  ✅ 일정 관리 앱
<br>

## 📆 1. 기능 및 조건

### Lv 0.  API 명세 및 ERD 작성  ###
* API 명세서 작성하기.
* ERD 작성하기.
* SQL 작성하기.

**일정 관리 API 명세서**

| 기능         | Method | URL              | Path Var  | request body | response                                                                                                   | 상태코드 |
|-------------|--------|-----------------|-----------|--------------|------------------------------------------------------------------------------------------------------------|----------|
| 일정 등록    | POST   | /api/todos      | X         | ``` { "todo": "할 일", "author": "작성자", "pw": "비밀번호", "created": "작성일", "modified": "수정일" }``` | ```  { "id": 일정 Id, "todo": "할 일", "author": "작성자", "pw": "비밀번호", "created": "작성일", "modified": "수정일" }``` | 201: CREATED  <br> 200: OK |
| 선택 일정 조회 | GET    | /api/todos/{id} | id(Long)  | X            | ``` { "id": 일정 Id, "todo": "할 일", "author": "작성자", "pw": "비밀번호", "created": "작성일", "modified": "수정일" }```  | 200: OK  <br> 404: NOT FOUND |
| 일정 목록 조회 | GET    | /api/todos      | X         | X            | X                                                                                                          | 200: OK |
| 일정 수정    | PUT    | /api/todos/{id} | id(Long)  | ``` { "todo": "할 일", "author": "작성자", "pw": "비밀번호" }``` | X                                                                                                          | 200: OK  <br> 404: NOT FOUND  <br> 400: BAD REQUEST  <br> 403: FORBIDDEN |
| 일정 삭제    | DELETE | /api/todos/{id} | id(Long)  | ``` { "pw": "비밀번호" }``` | X                                                                                                          | 200: OK  <br> 404: NOT FOUND  <br> 403: FORBIDDEN |


  <br>
  **ERD 작성**

  ![Image](https://github.com/user-attachments/assets/032cd5d7-d0d4-4aa3-b1db-c5de06836969)
  ![Image](https://github.com/user-attachments/assets/9b2f9d64-3ece-47a5-9b7d-ef7842343a2c)


### Lv 2. 메뉴를 클래스로 관리하기 ###
* `MenuItem` 클래스 생성하기.
* `main` 함수에서 `MenuItem` 클래스를 활용하여 카페 메뉴 출력.
  <br>

### Lv 3. 순서 제어를 클래스로 관리하기 ###
* `Kiosk` 클래스 생성하기.
    * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스.
    * main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리.
      <br>

### LV 4. 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기 ###
* `Menu` 클래스 생성하기.
    * ` MenuItem` 클래스를 관리하는 클래스.
    * 각 카테고리 내에 여러 `MenuItem`을 포함함.
    * 여러 커피들을 포함하는 상위 개념 ‘커피’ 같은 `카테고리 이름` 필드를 가짐.
    * 메뉴 카테고리 이름을 반환하는 메서드 구현.

<br>

## 📱 2. 작동순서
### 1. 카테고리 메뉴 출력
**☕ 커피**

**🍵 차**

**🥤 스무디**

<br>

### 2. 카테고리 선택 시 메뉴 출력
**☕ 커피**
1. Espresso | W 2500 | 고온ㆍ고압하에서 곱게 간 커피 가루에 물을 가해, 30초 이내에 내린 커피.
2. Americano | W 3000 | 에스프레소에 물을 넣어 연하게 마시는 커피.
3. Caffé Latte  | W 3500 | 에스프레소에 따뜻한 우유를 1:2 또는 1:3 정도의 비율로 섞은 커피.
4. Caramel Macchiato  | W 4000 | 에스프레소에 캐러멜 소스와 우유를 넣고 우유 거품만 살짝 올린 커피.
5. Café Mocha  | W 4500 | 에스프레소에 우유와 초콜릿을 넣고 휘핑크림을 올린 커피.
   <br>

**🍵 차**
1. Iced Peach Black Tea   | W 5000 | 복숭아의 진한 맛과 홍차의 조화가 매력적인 음료.
2. Grapefruit Honey Black Tea   | W 5300 | 새콤한 자몽과 달콤한 꿀, 블랙티의 만남.
3. Yuja Mint Tea   | W 6100 | 국내산 고흥 유자와 생강, 우릴수록 상쾌한 민트티가 조화로운 유자 민트 티.
4. Chamomile Blend Brewed Tea   | W 4500 | 캐모마일과 레몬 그라스, 레몬밤, 히비스커스 등 블렌딩되어 은은하고 차분한 향이 기분을 좋게 하는 허브 티.
5. Earl Grey Brewed Tea   | W 4500 | 꽃향 가득한 라벤더와 베르가못 향이 진한 홍차와 블렌딩된 향긋한 블랙티.
   <br>

**🥤 스무디**
1. Strawberry Yogurt Smoothie   | W 4700 | 딸기와 상큼한 요거트가 조화롭게 어우러진 스무디.
2. Honey Peach Smoothie   | W 3900 | 복숭아의 리얼한 풍미와 꿀의 달콤함이 최적의 조화를 이룬 달콤하고 시원한 스무디.
3. Vanilla Milk Shake   | W 6100 | 부드럽고 밀키한 우유의 맛을 진하게 즐길 수 있는 밀크 쉐이크.
4. Cookie Shake   | W 6500 | 부드러운 쉐이크에 달콤한 쿠키를 가득 올린 밀크 쉐이크.
5. Milk Tea Shake   | W 5500 | 홍차의 향긋한 풍미를 깊고 부드럽게 즐기는 밀크티 쉐이크.

<br>

### 3. 메뉴 선택 시 선택한 메뉴 출력, 0 입력 시 뒤로가기 실행.
```
메뉴를 선택해주세요 (0 입력 시 뒤로가기): 0
카테고리 메뉴로 돌아갑니다.
```
<br>

### 4. 메뉴 출력 후 카테고리 메뉴로 이동
```
메뉴를 선택해주세요 (0 입력 시 뒤로가기): 3
선택한 메뉴 : Yuja Mint Tea | 6100원 | 국내산 고흥 유자와 생강, 우릴수록 상쾌한 민트티가 조화로운 유자 민트 티.

[ SKY CAFE ]
1. COFFEE
2. TEA
3. SMOOTHIE
카테고리를 선택해주세요(종료 시 0 입력):
```
<br>

### 5. 0 선택 시 프로그램 종료
```
카테고리를 선택해주세요(종료 시 0 입력): 0
프로그램을 종료합니다.
```
<br>


## 3. 실행 결과
```
[ SKY CAFE ]
1. COFFEE
2. TEA
3. SMOOTHIE
카테고리를 선택해주세요(종료 시 0 입력): 1
[ COFFEE ]

1. Espresso   | W 2500 | 고온ㆍ고압하에서 곱게 간 커피 가루에 물을 가해, 30초 이내에 내린 커피.
2. Americano   | W 3000 | 에스프레소에 물을 넣어 연하게 마시는 커피.
3. Caffé Latte   | W 3500 | 에스프레소에 따뜻한 우유를 1:2 또는 1:3 정도의 비율로 섞은 커피.
4. Caramel Macchiato   | W 4000 | 에스프레소에 캐러멜 소스와 우유를 넣고 우유 거품만 살짝 올린 커피.
5. Café Mocha   | W 4500 | 에스프레소에 우유와 초콜릿을 넣고 휘핑크림을 올린 커피.

메뉴를 선택해주세요 (0 입력 시 뒤로가기): 2
선택한 메뉴 : Americano | 3000원 | 에스프레소에 물을 넣어 연하게 마시는 커피.

[ SKY CAFE ]
1. COFFEE
2. TEA
3. SMOOTHIE
카테고리를 선택해주세요(종료 시 0 입력): 2
[ TEA ]

1. Iced Peach Black Tea   | W 5000 | 복숭아의 진한 맛과 홍차의 조화가 매력적인 음료.
2. Grapefruit Honey Black Tea   | W 5300 | 새콤한 자몽과 달콤한 꿀, 블랙티의 만남.
3. Yuja Mint Tea   | W 6100 | 국내산 고흥 유자와 생강, 우릴수록 상쾌한 민트티가 조화로운 유자 민트 티.
4. Chamomile Blend Brewed Tea   | W 4500 | 캐모마일과 레몬 그라스, 레몬밤, 히비스커스 등 블렌딩되어 은은하고 차분한 향이 기분을 좋게 하는 허브 티.
5. Earl Grey Brewed Tea   | W 4500 | 꽃향 가득한 라벤더와 베르가못 향이 진한 홍차와 블렌딩된 향긋한 블랙티.

메뉴를 선택해주세요 (0 입력 시 뒤로가기): 3
선택한 메뉴 : Yuja Mint Tea | 6100원 | 국내산 고흥 유자와 생강, 우릴수록 상쾌한 민트티가 조화로운 유자 민트 티.

[ SKY CAFE ]
1. COFFEE
2. TEA
3. SMOOTHIE
카테고리를 선택해주세요(종료 시 0 입력): 3
[ SMOOTHIE ]

1. Strawberry Yogurt Smoothie   | W 4700 | 딸기와 상큼한 요거트가 조화롭게 어우러진 스무디.
2. Honey Peach Smoothie   | W 3900 | 복숭아의 리얼한 풍미와 꿀의 달콤함이 최적의 조화를 이룬 달콤하고 시원한 스무디.
3. Vanilla Milk Shake   | W 6100 | 부드럽고 밀키한 우유의 맛을 진하게 즐길 수 있는 밀크 쉐이크.
4. Cookie Shake   | W 6500 | 부드러운 쉐이크에 달콤한 쿠키를 가득 올린 밀크 쉐이크.
5. Milk Tea Shake   | W 5500 | 홍차의 향긋한 풍미를 깊고 부드럽게 즐기는 밀크티 쉐이크.

메뉴를 선택해주세요 (0 입력 시 뒤로가기): 0
카테고리 메뉴로 돌아갑니다.
[ SKY CAFE ]
1. COFFEE
2. TEA
3. SMOOTHIE
카테고리를 선택해주세요(종료 시 0 입력): 0
프로그램을 종료합니다.
```

<br><br>
