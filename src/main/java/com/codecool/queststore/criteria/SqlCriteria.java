package com.codecool.queststore.criteria;

import java.sql.PreparedStatement;

public interface SqlCriteria {
    PreparedStatement toPreparedStatement();
}
