package com.backend.skyblue.dto.request;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDto  implements Serializable {
    @Serial
    private static  final long serialVersionUID  = 1L;
    private Long id;
}
