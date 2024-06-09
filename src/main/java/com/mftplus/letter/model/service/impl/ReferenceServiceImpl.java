package com.mftplus.letter.model.service.impl;

import com.mftplus.letter.controller.exception.NoContentException;
import com.mftplus.letter.model.entity.Reference;
import com.mftplus.letter.model.entity.enums.ReferencePriority;
import com.mftplus.letter.model.service.interfaces.ReferenceService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SessionScoped
@Slf4j
public class ReferenceServiceImpl implements ReferenceService, Serializable {
    @PersistenceContext(unitName = "automation")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Reference reference) throws Exception {
        entityManager.persist(reference);
    }

    @Transactional
    @Override
    public void edit(Reference reference) throws NoContentException {
        Optional<Reference> optionalReference = Optional.ofNullable(entityManager.find(Reference.class, reference.getId()));

        if (optionalReference.isPresent()) {
            entityManager.merge(reference);
        } else {
            throw new NoContentException("Reference with id : " + reference.getId() + " not found !");
        }
    }

    //todo : no id check for methods
    @Transactional
    @Override
    public void remove(Reference reference) throws Exception {
        reference = entityManager.find(Reference.class, reference.getId());
        reference.setDeleted(true);
        entityManager.merge(reference);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Reference reference = entityManager.find(Reference.class, id);
        reference.setDeleted(true);
        entityManager.merge(reference);
    }

    @Transactional
    @Override
    public Optional<Reference> findById(Long id) throws NoContentException {
        Optional<Reference> optional = Optional.ofNullable(entityManager.find(Reference.class, id));
        if (optional.isPresent()) {
            return optional;
        } else {
            throw new NoContentException("Reference with id : " + id + "not found !");
        }
    }

    @Transactional
    @Override
    public List<Reference> findAll() throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.deleted=false", Reference.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByReferenceSenderId(String senderUsername) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.referenceSenderId.username=:senderUsername", Reference.class);
        query.setParameter("senderUsername",senderUsername);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByReferenceReceiverId(String receiverUsername) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.referenceReceiverId.username=:receiverUsername", Reference.class);
        query.setParameter("receiverUsername",receiverUsername);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByReferenceSenderIdAndDeletedFalse(String senderUsername) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.referenceSenderId.username=:senderUsername and oo.deleted=false", Reference.class);
        query.setParameter("senderUsername",senderUsername);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByReferenceReceiverIdAndDeletedFalse(String receiverUsername) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.referenceReceiverId.username=:receiverUsername and deleted=false", Reference.class);
        query.setParameter("receiverUsername",receiverUsername);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByRefDate(LocalDateTime refDateAndTime) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.refDateAndTime=:refDateAndTime", Reference.class);
        query.setParameter("refDateAndTime",refDateAndTime);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByLetterId(Long letterId) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.letterId.id=:letterId", Reference.class);
        query.setParameter("letterId",letterId);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByValidate(Boolean validate) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.validate=:validate", Reference.class);
        query.setParameter("validate",validate);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByParaph(String paraph) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.paraph=:paraph", Reference.class);
        query.setParameter("paraph",paraph);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByPriority(ReferencePriority priority) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.priority=:priority", Reference.class);
        query.setParameter("priority",priority);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<Reference> findByStatus(Boolean status) throws Exception {
        TypedQuery<Reference> query = entityManager.createQuery("select oo from referenceEntity oo where oo.status=:status", Reference.class);
        query.setParameter("status",status);
        return query.getResultList();
    }
}
