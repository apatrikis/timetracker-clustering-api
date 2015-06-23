/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.cluster;

import java.io.Serializable;
import java.util.Objects;

/**
 * This {@code POJO} contains the informations which are send in a
 * {@code JMS Message}.
 *
 * @author apatrikis
 */
public class ClusterMessage implements Serializable {

    private String sender;

    private String receiver;

    private String message;

    public ClusterMessage() {
    }

    /**
     * Constructor.
     *
     * @param sender The message sender identification.
     * @param receiver The message receiver identification.
     * @param message The message to be delivered.
     */
    public ClusterMessage(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    /**
     * Get the Sender.
     *
     * @return The sender.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Set the sender.
     *
     * @param sender The sender.
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Get the receiver.
     *
     * @return The reciever.
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Set teh reciever.
     *
     * @param receiver The receiver.
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * Get the message.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message.
     *
     * @param message The message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.sender);
        hash = 59 * hash + Objects.hashCode(this.receiver);
        hash = 59 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClusterMessage other = (ClusterMessage) obj;
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        if (!Objects.equals(this.receiver, other.receiver)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClusterMessage{" + "sender=" + sender + ", receiver=" + receiver + ", message=" + message + '}';
    }
}
