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

► 화면

- UI

  - 상단 툴바 구성
  - 하단탭 5개 구성
  - 아이콘은 svg 형식 사용

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
    [
      {
        "index": "1",
        "userUid": "userUid1",
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
        "watch": "102",
        "json_user": {
        "userUid": "userUid1",
        "nickName": "죽전거래인",
        "profile_url": "https://i.picsum.photos/id/684/200/200.jpg?hmac=Al0pymCRQr_mB6OlD9xW3UsgmSKDgnNPq2JLj3_CfUY",
        "neighbor": "죽전동",
        "temp": "38"
        }
        },
        {
        "index": "2",
        "userUid": "userUid2",
        "image_url1": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
        "image_url2": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
        "image_url3": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
        "image_url4": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
        "image_url5": "https://i.picsum.photos/id/599/200/200.jpg?hmac=2WLKs3sxIsaEQ-6WZaa6YMxgl6ZC4cNnid0aqupm2is",
        "title": "중고 거래합니다.",
        "content": "매직 마우스 팝니다.",
        "category": "디지털/PC",
        "chat": "2",
        "like": "2",
        "time": "2021. 11. 30 10:30",
        "watch": "30",
        "json_user": {
            "userUid": "userUid2",
            "nickName": "당근유저",
            "profile_url": "https://i.picsum.photos/id/684/200/200.jpg?hmac=Al0pymCRQr_mB6OlD9xW3UsgmSKDgnNPq2JLj3_CfUY",
            "neighbor": "금곡동",
            "temp": "39.5"
        }
      }
    ]
    ```

- 탭 동네생활
  - 동네생활 샘플 리스트 구현
    ```
    [
      {
        "address":"용인시 수지구",
        "content":"취미생활 공유합니다.",
        "good":3,
        "id":4,
        "imageUrl1":"image1",
        "imageUrl2":"image2",
        "imageUrl3":"image3",
        "nickName":"유저4",
        "reply":3,
        "time":"2022-05-28 01:00",
        "type":"취미생활"
      }
    ]
    ```
  - 동네생활 타입 설정
  - 동네생활 타입 클릭 시 해당 타입 리스트만 노출되는 화면으로 이동
