package com.duroop.dodom.domain.tag.entity;

import com.duroop.dodom.audit.BaseTimeEntity;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagId;
    private String tagName;

    @OneToMany(mappedBy = "tag", orphanRemoval = true)
    private List<Counselor> counselorList = new ArrayList<>();
}
