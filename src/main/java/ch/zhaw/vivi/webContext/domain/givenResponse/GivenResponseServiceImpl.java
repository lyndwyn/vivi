package ch.zhaw.vivi.webContext.domain.givenResponse;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity answer.
 *
 *
 */
@Service
public class GivenResponseServiceImpl extends ExtendedServiceImpl<GivenResponse> implements GivenResponseService {

    /**
     *
     * @param repository
     */
    public  GivenResponseServiceImpl(GivenResponseRepository repository) {
        super(repository);
    }

}