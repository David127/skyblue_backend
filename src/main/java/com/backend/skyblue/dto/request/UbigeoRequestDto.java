package com.backend.skyblue.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoRequestDto implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
}
