package org.template.regression

import org.apache.predictionio.controller.{EmptyEvaluationInfo, Engine, EngineFactory}

case class Query(vector: String)
case class PredictedResult(
  prediction: Double
)
case class ActualResult(label: Double)

/*object RegressionEngine extends EngineFactory {
  type Type = Engine[TrainingData, EmptyEvaluationInfo, PreparedData, Query, PredictedResult, ActualResult]

  def apply(): Type = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map(
        "tree" -> classOf[DecisionTreeRegression]
      ),
      classOf[Serving]
    )
  }
}*/
object ClassificationEngine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map("naive" -> classOf[NaiveBayesAlgorithm],
        "randomforest" -> classOf[RandomForestAlgorithm]), 
      classOf[Serving])
  }
}
