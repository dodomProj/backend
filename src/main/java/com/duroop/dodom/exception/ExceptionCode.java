package com.duroop.dodom.exception;

import lombok.Getter;


public enum ExceptionCode {

    // Resource
    BAD_REQUEST(400, "잘못된 요청 입니다."),
    NOT_FOUND(404, "페이지를 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(404, "등록되지 않은 회원입니다."),
    CONFLICT(409, "충돌이 났습니다."),
    MEMBER_EXIST(409, "이미 등록된 회원입니다."),
    NICKNAME_EXIST(409, "이미 등록된 닉네임입니다."),

    TOKEN_EXPIRED(409,"만료된 토큰입니다."),

    // Security
    UNAUTHORIZED(401, "사용자가 인증되지 않았습니다."),

    /**
     * Counselor - 600
     */
    COUNSELOR_NOT_FOUND(600,  "심리 상담사가 존재하지 않습니다."),

    /**
     * Appointment - 700
     */
    APPOINTMENT_NOT_FOUND(700, "예약된 상담이 존재하지 않습니다." ),

    /**
     * Review - 800
     */
    REVIEW_EXIST(801, "이미 리뷰가 작성되었습니다."),

    /**
     * Tag- 900
     */
    TAG_NOT_FOUND(900, "해당 아이디를 갖는 태그가 존재하지 않습니다.");


    @Getter
    private final int code;

    @Getter
    private final String message;


    ExceptionCode(int code, String message) {
        this.code =code;
        this.message = message;
    }
}
