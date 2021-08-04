package com.example.yztx.domain;

import jdk.nashorn.internal.objects.annotations.Getter;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class Sign implements Serializable {

    @Id
    public long signer_id;
    public String signer_name;
    public String signer_url;
    public long sign_time;





}
