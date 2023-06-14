//package com.duroop.dodom.counselor.service;
//
//import com.duroop.dodom.domain.counselor.repository.CounselorRepository;
//import com.duroop.dodom.domain.counselor.entity.Counselor;
//import com.duroop.dodom.domain.counselor.service.CounselorService;
//import com.duroop.dodom.domain.score.entity.Score;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import java.util.Optional;
//
//import static org.mockito.BDDMockito.given;
//
//
//public class CounselorServiceTest {
//
//    @Mock
//    CounselorRepository counselorRepository = Mockito.mock(CounselorRepository.class);
//
//    @Test
//    void createCounselor(){
//        //Given
//        CounselorService counselorService = new CounselorService(counselorRepository);
//
//        Counselor counselor = Counselor.builder()
//                .counselorId(1L)
//                .career(10)
//                .introduce("행복한 삶을 만들어드릴게요.")
//                .build();
//
//        Score score = Score.builder()
//                .scoreId(1L)
//                .score(4.5)
//                .build();
//
//        counselor.setScore(score);
//
//        //When
//        counselorService.createCounselor(counselor);
//        Long createdCounselorId = counselor.getCounselorId();
//
//        //Then
//        Assertions.assertNotNull(createdCounselorId);
//    }
//
//    @Test
//    void findCounselor(){
//        //Given
//        CounselorService counselorService = new CounselorService(counselorRepository);
//
//        Counselor counselor = Counselor.builder()
//                .counselorId(1L)
//                .career(10)
//                .introduce("행복한 삶을 만들어드릴게요.")
//                .build();
//
//        Score score = Score.builder()
//                .scoreId(1L)
//                .score(4.5)
//                .build();
//
//        counselor.setScore(score);
//
//        given(counselorRepository.findById(1L))
//                .willReturn(Optional.ofNullable(counselor));
//
//        //When
//        Counselor findCounselor = counselorService.findCounselor(1L);
//
//        //Then
//        Assertions.assertEquals(counselor, findCounselor);
//
//    }
//}
