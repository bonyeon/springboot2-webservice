package com.bonyeon.book.springboot.domain.posts;

import com.bonyeon.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //롬복 어노테이션, 클래스 내 모든 필드의 Getter 메소드를 생성
@NoArgsConstructor //롬복 어노테이션, 기본생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id//PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK생성 규칙
    //부트 2.0에서는 위의 옵션을 추가해야 auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false)
    //굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됨
    //사용하는 이유는 기본값 외에 추가로 변경이 필요한 경우 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    //롬복 어노테이션
    //해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
