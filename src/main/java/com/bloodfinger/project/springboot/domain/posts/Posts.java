package com.bloodfinger.project.springboot.domain.posts;

import com.bloodfinger.project.springboot.domain.BaseTimeEntity;
import com.bloodfinger.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content , String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void update(String title , String content){
        this.title = title;
        this.content = content;
    }
}


/*Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이다. 보통 Entity 클래스라 부른다.
    @Id -> 해당 테이블의 pk를 의미
    @Column -> 해당 테이블의 컬럼을 의미
               안써도 변수는 컬럼으로 사용되지만 타입이나 사이즈를 변경할때 사용한다.
    */

