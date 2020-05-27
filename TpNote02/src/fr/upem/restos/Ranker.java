package fr.upem.restos;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ranker<E> {
    private Map<E, List<Review>> selectionList;

    public Ranker() {
        selectionList = new HashMap<>();
    }

    public void addEvaluation(final E item, final int score, final String comment) {
        
        Objects.requireNonNull(comment, "comment cannot be null");
        List<Review> currentReviews = selectionList.get(Objects.requireNonNull(item, " item cannot be null"));
        if (currentReviews == null) {
            currentReviews = new ArrayList<Review>();
            selectionList.put(item, currentReviews);       
        }
        currentReviews.add(new Review(comment, score));
    }

    public void addEvaluation(final E item, final int score) {
        addEvaluation(item, score, "");
    }

    public float averageScoreFor(final E item) {

        List<Review> currentReviews = selectionList.get(Objects.requireNonNull(item));
        if (currentReviews != null) {
            return (float) currentReviews.stream().map(Review::score).reduce(0, Integer::sum) / currentReviews.size();
        }

        return 0.0f;
    }

    public void printCommentsForItemWithScoreBetterOrEqualsThan(final int score) {
        
        for (final E e : selectionList.keySet()) {
            final List<Review> currentReviews = selectionList.get(e);
            if (currentReviews != null) {
                System.out.println (e + " : " + currentReviews.stream().filter(r -> r.score() >= score).collect(Collectors.toList()));
            }
        }
    }

    public void printCommentsForItemVerifying(final Predicate<E> predicate) {
        for (final E e : selectionList.keySet().stream().filter(predicate).collect(Collectors.toList())) {
            final List<Review> currentReviews = selectionList.get(e);
            if (currentReviews != null) {
                System.out.println (e + ":" + currentReviews);
            }
        }
    }

}