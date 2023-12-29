package com.kaya.kaya01.DTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PhotosDTO  {

    private Integer id;

    private String url;

    private PropertyDTO property;

}
