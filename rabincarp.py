def rabin_karp_search(text, pattern, q):
    n = len(text)
    m = len(pattern)
    h_pattern = 0
    h_text = 0
    d = 256  # The number of characters in the input alphabet (ASCII)

    # Calculate (d^(m-1)) % q
    d_m_1 = 1
    for i in range(m - 1):
        d_m_1 = (d_m_1 * d) % q

    # Calculate the hash value of the pattern and the initial window of text
    for i in range(m):
        h_pattern = (d * h_pattern + ord(pattern[i])) % q
        h_text = (d * h_text + ord(text[i])) % q

    for i in range(n - m + 1):
        if h_pattern == h_text:
            # Check if the characters in the window match the pattern
            if text[i:i + m] == pattern:
                print(f"Pattern found at index {i}")

        if i < n - m:
            # Update the hash value for the next window
            h_text = (d * (h_text - ord(text[i]) * d_m_1) + ord(text[i + m])) % q

# Test cases
test_cases = [
    ("2359023141526739921", "31415", 13),
    ("ABAAABCDBBABCDDEBCABC", "ABC", 101)
]

for i, (text, pattern, q) in enumerate(test_cases):
    print(f"Test Case {i+1}:")
    print(f"Text: {text}")
    print(f"Pattern: {pattern}")
    print(f"q: {q}")
    rabin_karp_search(text, pattern, q)
    print()
