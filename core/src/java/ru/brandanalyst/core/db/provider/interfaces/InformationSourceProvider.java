package ru.brandanalyst.core.db.provider.interfaces;

import ru.brandanalyst.core.model.InfoSource;

import java.util.List;

public interface InformationSourceProvider {
    @Deprecated
    public void cleanDataStore();

    public void writeInfoSourceToDataStore(InfoSource infoSource);

    public void writeListOfInfoSourceToDataStore(List<InfoSource> infoSourceList);

    public InfoSource getInfoSourceById(long id);

    public List<InfoSource> getAllInfoSources();
}