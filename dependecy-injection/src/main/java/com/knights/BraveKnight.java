package com.knights;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class BraveKnight implements Knight {
    @NonNull
    private Quest quest;
    @Override
    public void embarkQuest() {
        quest.embark();
    }

}
