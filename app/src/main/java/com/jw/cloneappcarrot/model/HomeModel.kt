package com.jw.cloneappcarrot.model

/**
 * Created by LJW on 2021/12/03.
 *
 * Description : 홈 탭에서 사용되는 데이터 클래스
 */


// 동네 판매리스트 데이터 클래스
data class HomeModel(
    val index: Int,         // 게시글 구분 번호
    val userUid: String,    // 글쓴이 아이디값
    val type: String,       // 홍보, 판매글 구분
    val title: String,      // 제목
    val image_url: String,  // 대표 이미지 url
    val neighbor: String,   // 동네이름
    val time: String,       // 올린 시간
    val price: String,      // 가격
    val like: String,       // 좋아요 수
    val chat: String,       // 채팅 수
)
