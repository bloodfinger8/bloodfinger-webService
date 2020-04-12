package com.bloodfinger.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts , Long> {
}


/* JpaRepository< Entity 클래스 , PK 타입 > 상속한다면 기본적인 CRUD 메소드가 자동 생성
주의 해야하는 부분은 Entity 클래스와 기본 Entity Repository는 함께 위치해야 하는 점이다.
왜냐면 아주 밀접한 관계이고, Entity클래스는 기본 Repository 없이는 제대로 역할을 할 수 없다.
 */