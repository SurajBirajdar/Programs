package programs.program.newPrograms.binarySearch;

/**
 * ============================================================================
 * BOOK ALLOCATION PROBLEM - BINARY SEARCH SOLUTION
 * ============================================================================
 * PROBLEM STATEMENT:
 * Given an array of books where each element represents the number of pages
 * in a book, and 'k' students, we need to allocate books to students such that:
 * 1. Each student gets contiguous books (books cannot be split)
 * 2. Each student must get at least one book
 * 3. The maximum number of pages any student reads is MINIMIZED
 *
 * APPROACH: Binary Search
 * - We search for the minimum possible "maximum pages" in a given range
 * - Search space: minimum pages (largest single book) to total pages (all books)
 * - For each candidate answer (mid), we check if it's valid
 * ============================================================================
 */
public class BookAllocation {

    /**
     * MAIN METHOD - Entry point of the program
     * This method demonstrates the bookAllocation function with a sample input
     */
    public static void main(String[] args) {
        // Array representing number of pages in each book (in order)
        // These books must be allocated to students in the same order
        int[] arr = {10, 20, 30, 40, 50}; // Book 1 has 10 pages, Book 2 has 20 pages, etc.

        // Call the bookAllocation method with 2 students and store the result
        // Result: The minimum possible maximum pages any student will have
        System.out.println(bookAllocation(arr, 2)); // Expected output: 60
    }

    /**
     * VALIDATION FUNCTION - Checks if a given "maximum pages" value is feasible
     * This function answers: "Can we allocate books to k students such that
     * no student reads more than 'mid' pages?"
     *
     * @param arr - Array of books with their page counts
     * @param k - Number of students available
     * @param mid - The maximum pages a student can read (candidate answer)
     * @return true if allocation is possible with this mid value, false otherwise
     *
     * LOGIC:
     * - Start with 1 student having 0 pages
     * - Try to allocate books to current student (add pages)
     * - If adding next book exceeds 'mid', assign to next student
     * - If we run out of students (studentCount > k), return false
     * - If a single book > mid, it's impossible, return false
     */
    public static boolean isvalidAns(int[] arr, int k, int mid) {
        // Initialize studentCount to 1 because we start allocating to the first student
        int studentCount = 1;

        // pages variable tracks total pages allocated to current student
        int pages = 0;

        // Iterate through each book in the array
        for(int i = 0; i < arr.length; i++) {
            // Check if adding current book to current student exceeds the limit 'mid'
            if(pages + arr[i] <= mid) {
                // If we can add this book to current student (doesn't exceed mid)
                pages = pages + arr[i]; // Add current book's pages to current student's total
            } else {
                // If adding this book would exceed 'mid', we need to assign it to next student
                studentCount++; // Increment to next student

                // Check two failure conditions:
                // 1. If we have more students needed than available (studentCount > k)
                // 2. If any single book has pages > mid (impossible to assign to any student)
                if(studentCount > k || arr[i] > mid) {
                    return false; // Allocation is IMPOSSIBLE with this 'mid' value
                } else {
                    // Reset pages for new student and assign current book to them
                    pages = 0; // Start fresh for new student
                    pages = pages + arr[i]; // Assign current book to new student
                }
            }
        }
        // If we successfully assigned all books without exceeding k students
        return true; // Allocation is POSSIBLE with this 'mid' value
    }

    /**
     * BOOK ALLOCATION - Main Binary Search Function
     * Finds the minimum possible maximum pages any student must read
     *
     * @param arr - Array of books with page counts (must maintain order)
     * @param k - Number of students available for allocation
     * @return Minimum possible value of maximum pages among all students
     *         Returns -1 if allocation is impossible (more books than students)
     *
     * TIME COMPLEXITY: O(n * log(sum of pages))
     *   - Binary Search: O(log(sum)) iterations
     *   - Each iteration validates with O(n) operation
     *
     * SPACE COMPLEXITY: O(1) - Only using a few variables, no extra space
     *
     * ALGORITHM EXPLANATION:
     * 1. The answer lies between: [largest single book, sum of all books]
     * 2. Use binary search to find the minimum value where allocation is possible
     * 3. For each mid value, validate if it's achievable with k students
     * 4. If achievable, try for smaller value (e = mid - 1)
     * 5. If not achievable, increase the limit (s = mid + 1)
     */
    public static int bookAllocation(int[] arr, int k) {
        // BASE CASE: If more students than books, some students get nothing (invalid)
        if(arr.length < k) {
            return -1; // Return -1 indicating impossibility or invalid input
        }

        // Store length of array for easier reference throughout the code
        int n = arr.length;

        // START point of binary search
        // Minimum possible = 1 (hypothetically one student reads just 1 page)
        // But practically, minimum should be the largest book (can't split books)
        int s = 1; // s stands for 'start'

        // Calculate TOTAL pages in all books using a loop
        int sum = 0; // Initialize sum variable to store total pages
        for(int i = 0; i < n; i++) {
            sum = sum + arr[i]; // Add each book's pages to running total
        }

        // END point of binary search
        // Maximum possible = all books given to one student (worst case)
        int e = sum; // e stands for 'end'

        // Variable to store the final answer (valid minimum maximum pages)
        int ans = 0;

        // Variable to store the middle value during binary search
        int mid = 0;

        // BINARY SEARCH LOOP: Continue while start <= end
        while(s <= e) {
            // Calculate mid value using the formula: s + (e-s)/2
            // This avoids integer overflow compared to (s+e)/2
            mid = s + (e - s) / 2;

            // Check if it's VALID to use 'mid' as the maximum pages limit
            if(isvalidAns(arr, k, mid)) {
                // If valid (can allocate all books to k students with max = mid)
                ans = mid; // Store this answer as a potential solution
                e = mid - 1; // Try to find a smaller answer (move left in search space)
            } else {
                // If NOT valid (cannot allocate with this limit)
                s = mid + 1; // Increase the limit (move right in search space)
            }
        }

        // Return the minimum possible maximum pages value found
        return mid; // The binary search has converged to the answer
    }
}
