import React, { useState } from 'react';
import axios from 'axios';

function GradeCalculator() {
  const [numStudents, setNumStudents] = useState(0);
  const [results, setResults] = useState(null);

  const handleCalculate = async () => {
    // Make HTTP request to backend to calculate grades
    try {
      const response = await axios.post('http://localhost:8080/calculate', { numStudents });
      setResults(response.data);
    } catch (error) {
      console.error('Error calculating grades:', error);
    }
  };

  return (
    <div>
      <h1>Grade Calculator</h1>
      <label>Enter the number of students:</label>
      <input type="number" value={numStudents} onChange={(e) => setNumStudents(e.target.value)} />
      <button onClick={handleCalculate}>Calculate</button>
      {results && (
        <div>
          <p>Average grade: {results.average}</p>
          <p>Highest grade: {results.highest}</p>
          <p>Lowest grade: {results.lowest}</p>
        </div>
      )}
    </div>
  );
}

export default GradeCalculator;
