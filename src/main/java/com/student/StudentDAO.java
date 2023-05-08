package com.student;

import javax.sql.DataSource;

public interface StudentDAO {
    public void setDataSource(DataSource dataSource);
    public void updateDescription(Integer id, String description);
}
