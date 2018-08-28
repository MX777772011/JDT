package com.devplatform.business.mina.server.entity;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonNodeEntity {
	private String key;
	private JsonNode jsonNode;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public JsonNode getJsonNode() {
		return jsonNode;
	}

	public void setJsonNode(JsonNode jsonNode) {
		this.jsonNode = jsonNode;
	}

}
