# 당근마켓 클론앱

## 토이프로젝트로 당근마켓 클론앱 제작

► 개발환경

- 사용언어 : Kotlin

► 프로젝트 설정

- 코틀린 컴파일 위해 app.gradle에 id 'kotlin-kapt' 추가
- 바인딩 사용 설정
- 패키지 레이어 구분
  - feature : rlsmd
    - 각 화면별 패키지 생성
    - ex) splash, sign, main, setting ...
  - global
  - model
  - util
  - ...

## 화면별 작업 내용

► 스플래시 화면

- UI
  - 간단한 로고만 삽입
- 기능
  - 딜레이 1초 후 화면 이동

► 메인화면

- UI
  - 상단 툴바 구성
  - 하단탭 5개 구성
  - 아이콘은 svg 형식 사용
- 기능
  - 탭 홈
    - 동네설정은 일단 제외 후 리스트 구현 진행
    - 서버 통신을 하지 않으므로 FakeList 생성하여 데이터 역할
    - 리사이블러뷰 아이템 클릭 시 makeSceneTransitionAnimation 적용
  - 상품 상세보기
    - ViewPager2 사용하여 이미지 리스트 보여줌
    - 인디게이터 적용
    - 리사이클러뷰 클릭하였을때 해당 아이디값에 의해 데이터 처리해줘야하지만, 현재는 임시 json 파일을 assets 디렉터리에 생성하여 사용
    - 데이터 형식 샘플
    ```
    {
        "json_product": {
            "index": "1",
            "userUid": "userUid",
            "image_url1": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
            "image_url2": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
            "image_url3": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
            "image_url4": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
            "image_url5": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
            "title": "맥북 팝니다.",
            "content": "맥북 2018년 15인치 팝니다.\n직거래 선호합니다.",
            "category": "디지털/PC",
            "chat": "1",
            "like": "3",
            "time": "2021. 11. 11 10:30",
            "watch": "102"
        },
        "json_user": {
            "userUid": "String",
            "nickName": "죽전거래인",
            "profile_url": "profile_url",
            "neighbor": "죽전동",
            "temp": "38"
        }
    }
    ```
