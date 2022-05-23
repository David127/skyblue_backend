package com.backend.skyblue.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {
    private String origin;
    private String interaction;
    private long index;
    private long created = Instant.now().getEpochSecond();
    public Mensaje(String origin, String interaction) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
    }
    public Mensaje(String origin, String interaction, long index) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = index;
    }
    
}
