package com.dinesh.project.ms.dp.query.api.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdQuery {
    // The purpose of this query is to get the Product via Id from the database..
    private String id;
}
