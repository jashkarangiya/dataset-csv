def fractional_knapsack(items, capacity):
    # Calculate the value-to-weight ratio for each item
    value_per_weight = [(items[i][0] / items[i][1], i) for i in range(len(items)]
    
    # Sort the items by their value-to-weight ratio in descending order
    value_per_weight.sort(reverse=True)
    
    total_value = 0
    sack = [0] * len(items)
    
    for ratio, index in value_per_weight:
        if capacity == 0:
            break
        weight = min(capacity, items[index][1])
        total_value += weight * items[index][0] / items[index][1]
        sack[index] = weight
        capacity -= weight
    
    return total_value, sack

# Test cases
test_cases = [
    ([(1, 2), (2, 3), (5, 4)], 5),
    ([(10, 2), (5, 3), (15, 5), (7, 7), (6, 1), (18, 4), (3, 1)], 15),
    ([(12, 4), (10, 6), (8, 5), (11, 7), (14, 3), (7, 1), (9, 6)], 18)
]

for i, (items, capacity) in enumerate(test_cases):
    total_value, sack = fractional_knapsack(items, capacity)
    print(f"Test Case {i+1}: Total value for capacity {capacity} = {total_value}")
    print(f"Selected items: {[(items[i], sack[i]) for i in range(len(items)) if sack[i] > 0]}\n")
