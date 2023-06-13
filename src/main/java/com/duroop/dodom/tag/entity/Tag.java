package com.duroop.dodom.tag.entity;

import com.duroop.dodom.counselor.entity.Counselor;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tagId;
    private String tagName;

    @OneToMany(mappedBy = "tag", orphanRemoval = true)
    private List<Counselor> counselorList = new ArrayList<>();
}
