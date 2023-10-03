package com.example.meters_data_server_up.utilits;

import lombok.Data;

@Data
public class RespInfo {
    private int statusCode;
    private String message;

    public RespInfo() {}

   public RespInfo statusCode(int statusCode) {
       this.statusCode = statusCode;
       return this;
   }

   public RespInfo message(String message) {
       this.message = message;
       return this;
   }
}
