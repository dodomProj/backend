package com.duroop.dodom.domain.counselor.mapper;

import com.duroop.dodom.domain.counselor.dto.CounselorDto;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import com.duroop.dodom.domain.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CounselorMapper {
    default Counselor counselorPostToCounselor(CounselorDto.Post requestBody, Tag tag){
        return  Counselor.builder()
                .career(requestBody.getCareer())
                .introduce(requestBody.getIntroduce())
                .tag(tag)
                .build();
    }

    default CounselorDto.Response counselorToResponse(Counselor counselor){

        Integer career = counselor.getCareer();
        String introduce = counselor.getIntroduce();
        Double score = counselor.getScore().getScore();

        return CounselorDto.Response.builder()
                .counselorId(counselor.getCounselorId())
                .career(career)
                .introduce(introduce)
                .score(score).build();
    }

    List<CounselorDto.Response> counselorListToResponse(List<Counselor> counselorList);
}
