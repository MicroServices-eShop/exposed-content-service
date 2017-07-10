package kjkrol.eshop.exposedcontent.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PersonRole {
    @JsonProperty("actor")
    ACTOR,
    @JsonProperty("writer")
    WRITER,
    @JsonProperty("director")
    DIRECTOR,
    @JsonProperty("producer")
    PRODUCER
}
