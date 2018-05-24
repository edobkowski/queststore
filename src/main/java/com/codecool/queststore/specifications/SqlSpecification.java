package com.codecool.queststore.specifications;

import java.sql.PreparedStatement;

public interface SqlSpecification {
    PreparedStatement toQuery();
}
