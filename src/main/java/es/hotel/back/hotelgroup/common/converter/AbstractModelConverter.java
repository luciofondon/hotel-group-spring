package es.hotel.back.hotelgroup.common.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public abstract class AbstractModelConverter<A, D> {

    public AbstractModelConverter() {
    }

    public A toApiModel(D domainModel, Class<A> apiClass) {
        return domainModel != null ? getModelMapper().map(domainModel, apiClass) : null;
    }

    public D toDomainModel(A apiModel, Class<D> domainClass) {
        return apiModel != null ? getModelMapper().map(apiModel, domainClass) : null;
    }

    private static ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
