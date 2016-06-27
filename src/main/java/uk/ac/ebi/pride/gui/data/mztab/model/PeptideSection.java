package uk.ac.ebi.pride.gui.data.mztab.model;

import uk.ac.ebi.pride.gui.data.mztab.exceptions.InvalidProteinSection;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: px-submission-tool
 * Package: uk.ac.ebi.pride.gui.data.mztab.model
 * Timestamp: 2016-06-27 16:05
 * ---
 * © 2016 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * This class manages Peptide data in an mzTab document
 */

public class PeptideSection {

    public enum ColumnType {
        SEQUENCE,
        ACCESSION,
        UNIQUE,
        DATABASE,
        DATABASE_VERSION,
        SEARCH_ENGINE,
        BEST_SEARCH_ENGINE_SCORE,
        MODIFICATIONS,
        RETENTION_TIME,
        RETENTION_TIME_WINDOW,
        CHARGE,
        MASS_TO_CHARGE,
        PEPTIDE_ABUNDANCE_STUDY_VARIABLE,
        PEPTIDE_ABUNDANCE_STDEV_STUDY_VARIABLE,
        PEPTIDE_ABUNDANCE_STD_ERROR_STUDY_VARIABLE,
        SEARCH_ENGINE_SCORE_MS_RUN,
        PEPTIDE_ABUNDANCE_ASSAY,
        SPECTRA_REF,
        OPT_CUSTOM_ATTIBUTE,
        RELIABILITY,
        URI
    }

    // Present columns
    private Set<ProteinSection.ColumnType> columnsFound = new HashSet<>();

    /**
     * Report a column present at the given index
     *
     * @param index      where the reported column type has been found
     * @param columnType column type found
     */
    public void addColumn(int index, ProteinSection.ColumnType columnType) {
        // NOTE - We ignore the index, as we don't need it at this stage
        columnsFound.add(columnType);
    }

    /**
     * Returns true if a particular column type has been reported, at least once
     * @param columnType to look for
     * @return true if a particular column type has been reported, false otherwise
     */
    public boolean isColumnTypePresent(ProteinSection.ColumnType columnType) {
        return columnsFound.contains(columnType);
    }

    /**
     * Validation algorithm for the peptide section is, in part, coupled with the metadata section that describes the
     * mzTab document it belongs to.
     *
     * @param metaData Metadata section that describes the mzTab document where this section belongs to
     * @throws InvalidProteinSection thrown if this protein section is not valid
     */
    public void validate(MetaData metaData) throws InvalidProteinSection {
        // TODO
    }

}
