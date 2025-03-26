# ️ 📆 프로젝트 소개

###  ✅ 기본적인 CRUD가 제공되는 일정 관리 앱
<br>

## 📆 1. 기능 및 조건

### Lv 0.  API 명세 및 ERD 작성  ###
* API 명세서 작성하기.
* ERD 작성하기.
* SQL 작성하기.

<br><br>

**1. 일정 관리 API 명세서**

| 기능         | Method | URL              | Path Variable  | request body | response                                                                                                   | 상태코드 |
|-------------|--------|-----------------|-----------|--------------|------------------------------------------------------------------------------------------------------------|----------|
| 일정 등록    | POST   | /api/todos      | X         | ``` { "todo": "할 일", "author": "작성자", "pw": "비밀번호", "created": "작성일", "modified": "수정일" }``` | ```  { "id": 일정 Id, "todo": "할 일", "author": "작성자", "pw": "비밀번호", "created": "작성일", "modified": "수정일" }``` | 201: CREATED  <br> 200: OK |
| 선택 일정 조회 | GET    | /api/todos/{id} | id(Long)  | X            | ``` { "id": 일정 Id, "todo": "할 일", "author": "작성자", "pw": "비밀번호", "created": "작성일", "modified": "수정일" }```  | 200: OK  <br> 404: NOT FOUND |
| 일정 목록 조회 | GET    | /api/todos      | X         | ```request Param(required=false){”author” : String, ”modified”:Datetime```}            | X                                                                                                          | 200: OK |
| 일정 수정    | PUT    | /api/todos/{id} | id(Long)  | ``` { "todo": "할 일", "author": "작성자", "pw": "비밀번호" }``` | X                                                                                                          | 200: OK  <br> 404: NOT FOUND  <br> 400: BAD REQUEST  <br> 403: FORBIDDEN |
| 일정 삭제    | DELETE | /api/todos/{id} | id(Long)  | ``` { "pw": "비밀번호" }``` | X                                                                                                          | 200: OK  <br> 404: NOT FOUND  <br> 403: FORBIDDEN |


  <br><br>
  
  **2. ERD 작성**

<img src="https://github.com/user-attachments/assets/032cd5d7-d0d4-4aa3-b1db-c5de06836969" width="400" height="200"/>
<img src="https://github.com/user-attachments/assets/9b2f9d64-3ece-47a5-9b7d-ef7842343a2c" width="550" height="300"/>

<br><br>

  **3. SQL 작성하기**
  ```
  CREATE TABLE todo
(
    id     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '메모 식별자',
    todo	    VARCHAR(2000)	NOT NULL COMMENT '할일',
    author	    VARCHAR(20)	NOT NULL COMMENT '작성자',
    pw	VARCHAR(10)	NOT NULL COMMENT '비밀번호',
    created	    DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '작성일',
    modified	DATETIME DEFAULT CURRENT_TIMESTAMP	NOT NULL COMMENT '수정일'
);
  ```

<br>

### Lv 1. 일정 생성 및 조회 ###

**1. 일정 생성(일정 작성하기)**
  * 일정 생성 시, 포함되어야할 데이터
    - `할일`, `작성자명`, `비밀번호`, `작성/수정일`을 저장
    - `작성/수정일`은 날짜와 시간을 모두 포함한 형태
    - 각 일정의 고유 식별자(ID)를 자동으로 생성하여 관리
    - 최초 입력 시, 수정일은 작성일과 동일
   
 **2. 전체 일정 조회(등록된 일정 불러오기)**
   * 다음 **조건**을 바탕으로 등록된 일정 목록을 전부 조회
        - `수정일` (형식 : YYYY-MM-DD)
        - `작성자명`
    * 조건 중 한 가지만을 충족하거나, 둘 다 충족을 하지 않을 수도, 두 가지를 모두 충족할 수도 있습니다.
    * `수정일` 기준 내림차순으로 정렬하여 조회

**3. 선택 일정 조회(선택한 일정 정보 불러오기)**
  * 선택한 일정 단건의 정보를 조회할 수 있습니다.
  * 일정의 고유 식별자(ID)를 사용하여 조회합니다.

<br>
      
### Lv 2. 일정 수정 및 삭제 ###
**1. 선택한 일정 수정**
  * 선택한 일정 내용 중 `할일`, `작성자명` 만 수정 가능.
     - 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
     - `작성일` 은 변경할 수 없으며, `수정일` 은 수정 완료 시, 수정한 시점으로 변경합니다.
       
**2. 선택한 일정 삭제**
  * 선택한 일정을 삭제할 수 있습니다.
      - 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
      <br>

<br>


## 📆 2. 실행화면

* 생성
<img src="https://github.com/user-attachments/assets/c23abec7-7e35-465f-abae-071b17bfb863" width="500" height="400"/>
<br><br>

* 목록 조건 조회
<img src="https://github.com/user-attachments/assets/40006af1-96c5-4dd4-9bc4-d07806e4ca40" width="500" height="400"/>
<br><br>

* id로 조회
<img src="https://github.com/user-attachments/assets/df667aa1-17b2-48b9-8484-1930489a3a1f" width="500" height="400"/>
<br><br>

* 수정
<img src="https://github.com/user-attachments/assets/aaa42c72-4e9d-42b8-bafa-f59f8e9c594e" width="500" height="400"/>
<br><br>

* 삭제(비밀번호 일치 시)
<img src="https://github.com/user-attachments/assets/a5fec568-19d8-4e7a-b74c-6ae34102cdd0" width="500" height="400"/>
<br><br>

* 삭제(비밀번호 불일치 시)
<img src="https://github.com/user-attachments/assets/6146243b-0e0e-4182-abba-7dff32132c09" width="500" height="400"/>
<br><br>
