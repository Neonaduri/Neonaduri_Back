package com.project.neonaduri.review.repository;


import com.project.neonaduri.login.model.User;
import com.project.neonaduri.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // postId로 해당 게시물의 후기 list 가져오기
    List<Review> findAllByPostId(Long postId);
    //게시물의 총 리뷰개수 구하기
    Long countByPostId(Long postId);
    //게시물 지워질때 해당 리뷰도 지워짐
    void deleteAllByPostId(Long postId);
    //내가 쓴 후기 조회
    List<Review> findAllByUser(User user);
}
