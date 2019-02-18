package com.jv_lp_01;

import java.util.List;

public interface ISaveable {
    public List write();
    public void read(List<String> savedValues);
}
