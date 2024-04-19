package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

@Entity
@Table(name = "support_ticket")
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

   @Column(name = "user_id" , nullable = false)
    private Long userId;

    @Column(name = "subject" , nullable = false)
    private String subject;

    @Column(name = "message" , nullable = false)
    private String message;

    @Column(name = "creation_date" , nullable = false)
    private String creationDate;


}
