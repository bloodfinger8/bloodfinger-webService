package com.bloodfinger.project.springboot.service.posts;

import com.bloodfinger.project.springboot.domain.posts.Posts;
import com.bloodfinger.project.springboot.domain.posts.PostsRepository;
import com.bloodfinger.project.springboot.web.dto.PostsResponseDto;
import com.bloodfinger.project.springboot.web.dto.PostsSaveRequestDto;
import com.bloodfinger.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save (PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    //update에 쿼리문이 없는 이유는 JPA의 영속성 컨텍스트 때문입니다.
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("해당게시글이 없다. id=" + id) );
        posts.update(requestDto.getTitle() , requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("해당 게시글 앖다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
