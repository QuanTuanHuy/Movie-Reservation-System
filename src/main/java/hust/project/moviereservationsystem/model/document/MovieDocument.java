package hust.project.moviereservationsystem.model.document;

import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "movie")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String description;

    private Long duration;

//    @Field(type = FieldType.Date, format = DateFormat.date)
//    private LocalDate releaseDate;

    @Field(type = FieldType.Keyword)
    private String language;

    @Field(type = FieldType.Keyword)
    private String country;

    @Field(type = FieldType.Keyword)
    private List<String> actors;

    @Field(type = FieldType.Keyword)
    private List<String> genres;

    private String director;

    private String bannerImg;

    private String trailer;

    @Field(type = FieldType.Integer)
    private Long ageLimit;
}
