package carsale.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HistoryOwnerDto {

    private String carName;
    private String ownerName;
    private String startDate;
    private String endDate;

    private String seriesDocs;
    private Long numberDocs;
}
