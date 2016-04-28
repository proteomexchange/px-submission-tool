package uk.ac.ebi.pride.gui.form;

import org.jdesktop.swingx.prompt.PromptSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.App;
import uk.ac.ebi.pride.gui.GUIUtilities;
import uk.ac.ebi.pride.gui.data.FeedbackFormModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

/**
 * Project: px-submission-tool
 * Package: uk.ac.ebi.pride.gui.form
 * Timestamp: 2016-04-27 15:31
 * ---
 * © 2016 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * ---
 * This controller is in charge of the Feedback sub-form within the submission form
 */
public class FeedbackFormController extends Form implements ActionListener {
    private static final Logger logger = LoggerFactory.getLogger(SubmissionForm.class);

    // Button action commands
    private static final String RATING_BUTTON_ACTION_VERY_BAD = "rating_button_action_very_bad";
    private static final String RATING_BUTTON_ACTION_BAD = "rating_button_action_bad";
    private static final String RATING_BUTTON_ACTION_NEUTRAL = "rating_button_action_neutral";
    private static final String RATING_BUTTON_ACTION_GOOD = "rating_button_action_good";
    private static final String RATING_BUTTON_ACTION_VERY_GOOD = "rating_button_action_very_good";

    // Submission data
    private FeedbackFormModel model;

    // Form components
    JPanel feedbackFramePanel;
    JPanel feedbackMainPanel;
    JPanel ratingPanel;
    JPanel additionalFeedbackInfoPanel;
    ButtonGroup ratingButtonsGroup;

    public FeedbackFormController(String subRef) {
        model = new FeedbackFormModel(subRef);
        initComponents();
    }

    private void initComponents() {
// Feedback Frame panel providing panel position and padding
        feedbackFramePanel = new JPanel(new BorderLayout());
        feedbackFramePanel.setBorder(new EmptyBorder(20, 0, 10, 0));
        feedbackFramePanel.setPreferredSize(new Dimension(500, 200));

        // Feedback Main panel, contains the actual feedback components
        feedbackMainPanel = new JPanel(new BorderLayout());
        //feedbackMainPanel.setBackground(Color.LIGHT_GRAY);

        // Title for feedback
        // WARNING - This component has been removed from the final version of the panel
        // JLabel formTitle = new JLabel();
        // formTitle.setBorder(new EmptyBorder(5, 10, 0, 0));
        // formTitle.setHorizontalAlignment(SwingConstants.LEFT);
        // formTitle.setVerticalAlignment(SwingConstants.TOP);
        // formTitle.setFont(formTitle.getFont().deriveFont(16f));
        // formTitle.setText(App.getInstance().getDesktopContext().getProperty("feedback.form.title"));
        // Add it to the main panel
        //feedbackMainPanel.add(formTitle, BorderLayout.NORTH);

        // Rating Panel
        ratingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ratingPanel.setBorder(new EmptyBorder(5, 5, 0, 5));
        ratingPanel.setOpaque(false);
        // Smiley buttons
        // Very bad experience
        Icon veryBadExperienceIcon = GUIUtilities.loadIcon(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.very_bad.icon"));
        JRadioButton veryBadExperienceButton = new JRadioButton(veryBadExperienceIcon);
        veryBadExperienceButton.setOpaque(false);
        veryBadExperienceButton.setToolTipText(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.very_bad.tooltip"));
        veryBadExperienceButton.setActionCommand(RATING_BUTTON_ACTION_VERY_BAD);
        veryBadExperienceButton.addActionListener(this);
        // Bad experience
        Icon badExperienceIcon = GUIUtilities.loadIcon(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.bad.icon"));
        JRadioButton badExperienceButton = new JRadioButton(badExperienceIcon);
        badExperienceButton.setToolTipText(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.bad.tooltip"));
        badExperienceButton.setOpaque(false);
        badExperienceButton.setActionCommand(RATING_BUTTON_ACTION_BAD);
        badExperienceButton.addActionListener(this);
        // Neutral experience
        Icon neutralExperienceIcon = GUIUtilities.loadIcon(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.neutral.icon"));
        JRadioButton neutralExperienceButton = new JRadioButton(neutralExperienceIcon);
        neutralExperienceButton.setToolTipText(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.neutral.tooltip"));
        neutralExperienceButton.setOpaque(false);
        neutralExperienceButton.setSelected(true);
        neutralExperienceButton.setActionCommand(RATING_BUTTON_ACTION_NEUTRAL);
        neutralExperienceButton.addActionListener(this);
        // Good experience
        Icon goodExperienceIcon = GUIUtilities.loadIcon(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.good.icon"));
        JRadioButton goodExperienceButton = new JRadioButton(goodExperienceIcon);
        goodExperienceButton.setToolTipText(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.good.tooltip"));
        goodExperienceButton.setOpaque(false);
        goodExperienceButton.setActionCommand(RATING_BUTTON_ACTION_GOOD);
        goodExperienceButton.addActionListener(this);
        // Very good experience
        Icon veryGoodExperienceIcon = GUIUtilities.loadIcon(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.very_good.icon"));
        JRadioButton veryGoodExperienceButton = new JRadioButton(veryGoodExperienceIcon);
        veryGoodExperienceButton.setToolTipText(App.getInstance().getDesktopContext().getProperty("feedback.form.rate.very_good.tooltip"));
        veryGoodExperienceButton.setOpaque(false);
        veryGoodExperienceButton.setActionCommand(RATING_BUTTON_ACTION_VERY_GOOD);
        veryGoodExperienceButton.addActionListener(this);
        // Add buttons to the panel
        ratingPanel.add(veryBadExperienceButton);
        ratingPanel.add(badExperienceButton);
        ratingPanel.add(neutralExperienceButton);
        ratingPanel.add(goodExperienceButton);
        ratingPanel.add(veryGoodExperienceButton);
        // Radio buttons group
        ratingButtonsGroup = new ButtonGroup();
        ratingButtonsGroup.add(veryBadExperienceButton);
        ratingButtonsGroup.add(badExperienceButton);
        ratingButtonsGroup.add(neutralExperienceButton);
        ratingButtonsGroup.add(goodExperienceButton);
        ratingButtonsGroup.add(veryGoodExperienceButton);
        // TEST
        //veryBadExperienceButton.setBorderPainted(true);
        //veryBadExperienceButton.setBorder(BorderFactory.createLoweredBevelBorder());
        // Add rating panel to main panel
        feedbackMainPanel.add(ratingPanel, BorderLayout.CENTER);

        // Additional comments
        additionalFeedbackInfoPanel = new JPanel(new BorderLayout());
        additionalFeedbackInfoPanel.setBorder(new EmptyBorder(0, 5, 15, 5));
        additionalFeedbackInfoPanel.setOpaque(false);
        // Text box
        JTextArea feedbackAdditionalInfoText = new JTextArea(7, 1);
        feedbackAdditionalInfoText.setLineWrap(true);
        feedbackAdditionalInfoText.setWrapStyleWord(true);
        PromptSupport.setPrompt(App.getInstance().getDesktopContext().getProperty("feedback.form.comments.placeholder_text"), feedbackAdditionalInfoText);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, feedbackAdditionalInfoText);
        PromptSupport.setFontStyle(Font.ITALIC, feedbackAdditionalInfoText);
        PromptSupport.setForeground(Color.LIGHT_GRAY, feedbackAdditionalInfoText);
        JScrollPane fbAdditionalInfoScrollPane = new JScrollPane(feedbackAdditionalInfoText);
        //fbAdditionalInfoScrollPane.setAutoscrolls(true);
        // Attach elements to panel
        additionalFeedbackInfoPanel.add(fbAdditionalInfoScrollPane, BorderLayout.CENTER);
        // Add additional feedback panel to main feedback panel
        feedbackMainPanel.add(additionalFeedbackInfoPanel, BorderLayout.SOUTH);

        // Add main panel to frame panel
        feedbackFramePanel.add(feedbackMainPanel, BorderLayout.CENTER);
    }

    public void addToParentForm(Form form, Object constraints) {
        form.add(feedbackFramePanel, constraints);
        form.revalidate();
        form.repaint();
    }

    public boolean doSubmitFeedback() {
        if (!model.isFeedbackProvided() && !model.isFeedbackProvisionRejected()) {
            int result = JOptionPane.showConfirmDialog((Component) null, App.getInstance().getDesktopContext().getProperty("feedback.form.confirmation_dialog.message"),
                    "Feedback", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, GUIUtilities.loadIcon(App.getInstance().getDesktopContext().getProperty("feedback.form.confirmation_dialog.icon")));
            if (result == 1) {
                return true;
            }
            return false;
        }
        if (model.isFeedbackProvided()) {
            // TODO - Retrieve the comments, if any
            return model.save();
        }
        return true;
    }

    private void applyRadioSelectionStyle(AbstractButton b) {
        b.setBorder(BorderFactory.createLoweredBevelBorder());
        b.setBorderPainted(true);
    }

    private void applyRadioDeselectedStyle(AbstractButton b) {
        b.setBorderPainted(false);
    }

    private void updateRadioButtonsAspect() {
        for (AbstractButton b : Collections.list(ratingButtonsGroup.getElements())) {
            if (b.isSelected()) {
                applyRadioSelectionStyle(b);
            } else {
                applyRadioDeselectedStyle(b);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(RATING_BUTTON_ACTION_VERY_BAD)) {
            model.setRating(FeedbackFormModel.RATING_VERY_BAD);
        } else if (e.getActionCommand().equals(RATING_BUTTON_ACTION_BAD)) {
            model.setRating(FeedbackFormModel.RATING_BAD);
        } else if (e.getActionCommand().equals(RATING_BUTTON_ACTION_NEUTRAL)) {
            model.setRating(FeedbackFormModel.RATING_NEUTRAL);
        } else if (e.getActionCommand().equals(RATING_BUTTON_ACTION_GOOD)) {
            model.setRating(FeedbackFormModel.RATING_GOOD);
        } else if (e.getActionCommand().equals(RATING_BUTTON_ACTION_VERY_GOOD)) {
            model.setRating(FeedbackFormModel.RATING_VERY_GOOD);
        } else {
            logger.error("Action Command '" + e.getActionCommand() + "' NOT RECOGNIZED");
        }
        updateRadioButtonsAspect();
    }
}
