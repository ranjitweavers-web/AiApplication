package com.example.aiapplication.model;

import jakarta.persistence.*;

@Entity
public class DocumentEmbedding {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "vector(1536)")
	private String embedding;

	@Column(columnDefinition = "TEXT")
	private String text;

	@Column(columnDefinition = "JSONB")
	private String metadata;

}
